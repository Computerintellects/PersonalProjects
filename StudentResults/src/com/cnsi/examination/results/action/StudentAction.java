package com.cnsi.examination.results.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.cnsi.examination.results.Constants;
import com.cnsi.examination.results.form.StudentForm;
import com.cnsi.examination.results.service.StudentDaoService;
import com.cnsi.examination.results.service.StudentService;
import com.cnsi.examination.results.vo.Student;

public class StudentAction extends DispatchAction {
    private Log logger = LogFactory.getLog(this.getClass());
    private static StudentService stdService = new StudentDaoService();
    
    public ActionForward getStudents(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getStudents");
        populateStudents(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpForInsertOrUpdate");
        StudentForm studentForm = (StudentForm)form;
        if (isUpdate(request, studentForm)) {
            Integer id = Integer.valueOf(studentForm.getStd());
            Student Student = stdService.getStudent(id);
            BeanUtils.copyProperties(studentForm, Student);
        }
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("delete");
        StudentForm studentForm = (StudentForm)form;
        Integer id = Integer.valueOf(studentForm.getStd());
        stdService.deleteStudent(id);
        populateStudents(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("insertOrUpdate");
        StudentForm studentForm = (StudentForm)form;
        if (validationSuccessful(request, studentForm)) {
            Student Student = new Student();
            BeanUtils.copyProperties(Student, studentForm);
            if (isUpdate(request, studentForm)) {
                logger.debug("update");
                stdService.updateStudent(Student);
            } else {
                logger.debug("insert" );
                stdService.insertStudent(Student);
            }
            populateStudents(request);
            return mapping.findForward(Constants.SUCCESS);
        } else {
            return mapping.findForward(Constants.FAILURE);
        }
    }

    private void populateStudents(HttpServletRequest request) {
        List students = stdService.getAllStudents();
        request.setAttribute(Constants.STUDENTS, students);
    }

    private boolean isUpdate(HttpServletRequest request, StudentForm empForm) {
        boolean updateFlag = true;
        //if ID is null or 0 we know we are doing an insert. You could check other
        //things to decide, like a dispatch param
        //It's annoying that BeanUtils will convert nulls to 0 so have to do 0 check also,
        //or you could register a converter, which is the preferred way to handle it, but goes
        //beyond this demo
        String id = empForm.getStd();
       if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
       
        request.setAttribute("updateFlag", Boolean.valueOf(updateFlag));
        return updateFlag;
    }

    private boolean validationSuccessful(HttpServletRequest request, StudentForm form) {
        //if you really like using the validation framework stuff, you can just
        //call  ActionErrors errors = form.validate( mapping, request ); in this method
        //and check for errors being empty, if not save them and you're done.
        //I end up finding the validation framework a bit annoying to work with, so I do it
        //old-Skool way. Inevitably in a more complex app you end up having to perform
        //more complex validation than the validation framework provides, so I just assume
        //keep it all here in one place, versus having some handled by xml configuration and
        //some hardcoded.
        boolean isOk = true;
        ActionMessages errors = new ActionMessages();
       /* if (form.getAge() == null || form.getAge().trim().length() == 0) {
            errors.add("age", new ActionMessage("errors.required", "Age"));
        } else {
            try {
                Integer.parseInt(form.getAge());
            } catch (NumberFormatException e) {
                errors.add("age", new ActionMessage("errors.number", "Age"));
            }
        }
        if (form.getFirstName() == null || form.getFirstName().trim().length() == 0) {
            errors.add("firstName", new ActionMessage("errors.required", "First Name"));
        }
        if (form.getLastName() == null || form.getLastName().trim().length() == 0) {
            errors.add("lastName", new ActionMessage("errors.required", "Last Name"));
        }*/
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            isOk = false;
        }
        return isOk;
    }

}
