package wicket.quickstart.yui;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.template.PackagedTextTemplate;

public class ToolTip extends WebPage {

public ToolTip(String id, String elementId) {
//super();

/*Map variables = new HashMap(7);
variables.put("context", elementId);
variables.put("text", "My Custom ToolTip text");

PackagedTextTemplate template = new PackagedTextTemplate(this
.getClass(), "tooltip.js");*/

Label label = new Label("mylabel", "This text has a tooltip");
WebMarkupContainer container = new WebMarkupContainer("parent");
add (container);
container.add (label.setOutputMarkupId(true));
add (new ToolTip("tooltip", label.getMarkupId()));

}

}
