package com.which.product.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(MockitoJUnitRunner.class)
public class HamcrestExample {

    @Test
    public void coreMatchers() {
//        anything - always matches, useful if you don't care what the object under test is
//        describedAs - decorator to adding custom failure description
//        is - decorator to improve readability - see "Sugar", below
        Person rashmi = new Person("Rashmi");

        assertThat(rashmi, is(new Person("Siby")));
        assertThat(rashmi, anything());
    }

    @Test
    public void logicalMathcers() {
//        allOf - matches if all matchers match, short circuits (like Java &&)
//        anyOf - matches if any matchers match, short circuits (like Java ||)
//        not - matches if the wrapped matcher doesn't match and vice versa
        assertThat("Hello", is(allOf(notNullValue(), instanceOf(String.class), equalTo("Hello"))));
        assertThat("Hello", is(not(allOf(notNullValue(), instanceOf(Integer.class)))));
        assertThat("Hello", is(any(Object.class)));
    }



    @Test
    public void objectMatchers() {
//        equalTo - test object equality using Object.equals
//        hasToString - test Object.toString
//        instanceOf, isCompatibleType - test type
//        notNullValue, nullValue - test for null
//        sameInstance - test object identity
        assertThat("Hello", is(notNullValue()));
        assertThat(null, is(nullValue()));
        Object object = new Object();
        Object sameObject = object;
        assertThat(object, is(sameInstance(sameObject)));
        assertThat("Hello", instanceOf(String.class));
    }

    @Test
    public void beanMatcher() {
//        hasProperty - test JavaBeans properties
        Person person = new Person("Rashmi");
        assertThat(person, hasProperty("name"));
    }

    @Test
    public void collectionsMatcher() {
//        array - test an array's elements against an array of matchers
//        hasEntry, hasKey, hasValue - test a map contains an entry, key or value
//        hasItem, hasItems - test a collection contains elements
//        hasItemInArray - test an array contains an element
        // given
        List<String> testers = new ArrayList<String>();
        testers.add("Nayab");
        testers.add("Rashmi");
        testers.add("Ashley");

        assertThat(testers.size(), is(3));
        assertThat(testers, hasItems("Nayab", "Ashley"));

        Map<String, Person> personsCol = new HashMap<>();
        personsCol.put("leadTester", new Person("Nayab"));

        assertThat(personsCol, hasEntry("leadTester", new Person("Nayab")));

    }

    @Test
    public void numberMatcher() {
//        closeTo - test floating point values are close to a given value
//        greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - test ordering
    }

    @Test
    public void textMatcher() {
//        equalToIgnoringCase - test string equality ignoring case
//        equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
//        containsString, endsWith, startsWith - test string matching
    }


}
