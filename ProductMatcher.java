package com.which.product.api.test.matchers;

import com.which.product.domain.*;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.compare;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class ProductMatcher {

    private static final Logger logger = LoggerFactory.getLogger(ProductMatcher.class);

    public static Matcher<? super Product> isSimilarTo(final Product testedSimilarProduct) {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product nonTestedSimilarProduct, Description mismatchDescription) {
                if (nonTestedSimilarProduct.isBestBuy() != testedSimilarProduct.isBestBuy()) {
                    mismatchDescription.appendText(String.format("Mismatch BestBuy:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProduct.isBestBuy(), testedSimilarProduct.isBestBuy()));
                    return false;
                }
                if (nonTestedSimilarProduct.isDontBuy() != testedSimilarProduct.isDontBuy()) {
                    mismatchDescription.appendText(String.format("Mismatch DontBuy:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProduct.isDontBuy(), testedSimilarProduct.isDontBuy()));
                    return false;
                }

                if (compare(nonTestedSimilarProduct.getScore(), testedSimilarProduct.getScore()) != 0) {
                    mismatchDescription.appendText(String.format("Mismatch Score:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProduct.getScore(), testedSimilarProduct.getScore()));
                    return false;
                }
                List<Tab> nonTestedSimilarProductTabs = nonTestedSimilarProduct.getTabs();
                List<Tab> testedSimilarProductTabs = testedSimilarProduct.getTabs();


                if ((nonTestedSimilarProductTabs != null && !nonTestedSimilarProductTabs.equals(testedSimilarProductTabs)) || (testedSimilarProductTabs == null)) {
                    mismatchDescription.appendText(String.format("Mismatch Tabs:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProductTabs, testedSimilarProductTabs));
                    return false;
                }

                // Review based matching
                WhichReviewedContent nonTestedSimilarProductContents = nonTestedSimilarProduct.getContents();
                WhichReviewedContent testedSimilarProductContents = testedSimilarProduct.getContents();
                if ((nonTestedSimilarProductContents != null && !nonTestedSimilarProductContents.isSimilarForTV(testedSimilarProductContents)) || (testedSimilarProductContents == null)) {
                    mismatchDescription.appendText("Mismatch contents");
                    return false;
                }

                // Manufacturer based matching
                Manufacturer nonTestedSimilarProductManufacturer = nonTestedSimilarProduct.getManufacturer();
                Manufacturer testedSimilarProductManufacturer = testedSimilarProduct.getManufacturer();
                if (nonTestedSimilarProductManufacturer != testedSimilarProductManufacturer && (nonTestedSimilarProductManufacturer == null || testedSimilarProductManufacturer == null)) {
                    mismatchDescription.appendText("Mismatch manufacturer");
                    return false;
                }

                if (compare(nonTestedSimilarProductManufacturer.getReliabilityScore(), testedSimilarProductManufacturer.getReliabilityScore()) != 0) {
                    mismatchDescription.appendText(String.format("Mismatch Reliability:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProductManufacturer.getReliabilityScore(), testedSimilarProductManufacturer.getReliabilityScore()));
                    return false;
                }

                if (compare(nonTestedSimilarProductManufacturer.getSatisfactionScore(), testedSimilarProductManufacturer.getSatisfactionScore()) != 0) {
                    mismatchDescription.appendText(String.format("Mismatch SatisfactionScore:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProductManufacturer.getSatisfactionScore(), testedSimilarProductManufacturer.getSatisfactionScore()));
                    return false;
                }


                // Test results matching
                List<PropertyGroup> nonTestedSimilarProductPropertyGroups = nonTestedSimilarProduct.getPropertyGroupTypes().get("Test Results");
                List<PropertyGroup> testedSimilarProductPropertyGroups = testedSimilarProduct.getPropertyGroupTypes().get("Test Results");

                if ((nonTestedSimilarProductPropertyGroups != null && !nonTestedSimilarProductPropertyGroups.equals(testedSimilarProductPropertyGroups)) || (testedSimilarProductPropertyGroups == null)) {
                    mismatchDescription.appendText(String.format("Mismatch TestResults:NonTestedSimilarProduct:%sTestedSimilarProduct:%s", nonTestedSimilarProductPropertyGroups, testedSimilarProductPropertyGroups));
                    return false;
                }
                return true;

            }

            @Override
            public void describeTo(Description description) {
                description.appendText(testedSimilarProduct.toString());
            }
        };
    }

    public static Matcher<? super Product> isNotTested() {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product item, Description mismatchDescription) {
                if (item.getScore() != null) {
                    mismatchDescription.appendText("Score not NULL");
                    return false;
                }
                if (item.getTestingDate() != null) {
                    mismatchDescription.appendText("TestingDate not NULL");
                    return false;
                }
                if (!item.getContents().isEmpty()) {
                    mismatchDescription.appendText("Contents not empty");
                    return false;
                }
                return true;
            }

            @Override
            public void describeTo(Description description) {
                // no description
            }
        };
    }

    public static Matcher<? super Product> isTested() {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product item, Description mismatchDescription) {
                if (item.getScore() == null) {
                    mismatchDescription.appendText("Score is NULL");
                    return false;
                }
                if (item.getTestingDate() == null) {
                    mismatchDescription.appendText("TestingDate is NULL");
                    return false;
                }
                if (item.getContents().isEmpty()) {
                    mismatchDescription.appendText("Contents is empty");
                    return false;
                }
                return true;
            }

            @Override
            public void describeTo(Description description) {
                // no description
            }
        };
    }

    public static Matcher<? super Product> hasReviewContents() {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product item, Description mismatchDescription) {
                boolean returnValue = true;
                StringBuilder errorMsg = new StringBuilder();
                WhichReviewedContent contents = item.getContents();
                if (contents == null) {
                    errorMsg.append("Contents=null,");
                    returnValue = false;
                }
                if (isBlank(contents.getPros())) {
                    errorMsg.append("Contents[pros]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getCons())) {
                    errorMsg.append("Contents[cons]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getFull_review())) {
                    errorMsg.append("Contents[full_review]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getVerdict())) {
                    errorMsg.append("Contents[verdict]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getSeo_description())) {
                    errorMsg.append("Contents[seo_description]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getTeaser())) {
                    errorMsg.append("Contents[teaser]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getProduct_id())) {
                    errorMsg.append("Contents[product_id]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getProduct_category_id())) {
                    errorMsg.append("Contents[category_id]=blank,");
                    returnValue = false;
                }
                if (isBlank(contents.getSummary())) {
                    errorMsg.append("Contents[summary]=blank,");
                    returnValue = false;
                }
                mismatchDescription.appendText(errorMsg.toString());
                return returnValue;
            }

            @Override
            public void describeTo(Description description) {
                // nothing to add
            }
        };
    }

    public static Matcher<? super Product> hasNoReviewContents() {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product item, Description mismatchDescription) {
                boolean returnValue = true;
                StringBuilder errorMsg = new StringBuilder();
                WhichReviewedContent contents = item.getContents();
                if (contents == null) {
                    errorMsg.append("Contents=NULL,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getPros())) {
                    errorMsg.append("Contents[pros]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getCons())) {
                    errorMsg.append("Contents[cons]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getFull_review())) {
                    errorMsg.append("Contents[full_review]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getVerdict())) {
                    errorMsg.append("Contents[verdict]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getSeo_description())) {
                    errorMsg.append("Contents[seo_description]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getTeaser())) {
                    errorMsg.append("Contents[teaser]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getProduct_id())) {
                    errorMsg.append("Contents[product_id]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getProduct_category_id())) {
                    errorMsg.append("Contents[category_id]=notBlank,");
                    returnValue = false;
                }
                if (isNotBlank(contents.getSummary())) {
                    errorMsg.append("Contents[summary]=notBlank,");
                    returnValue = false;
                }
                mismatchDescription.appendText(errorMsg.toString());
                return returnValue;
            }

            @Override
            public void describeTo(Description description) {
                // nothing to add
            }
        };
    }

    public static Matcher<? super Product> scoreAndTestingDateNotMutuallyExclusive() {
        return new TypeSafeDiagnosingMatcher<Product>() {
            @Override
            protected boolean matchesSafely(Product item, Description mismatchDescription) {
                boolean retValue;
                StringBuilder errMsg = new StringBuilder();
                if (item.getScore() == null ^ item.getTestingDate() == null) {
                    errMsg.append(String.format("scoreAndTestingDateNotMutuallyExclusive:ProductId=%s, Issue=Score=%s, TestingDate=%s", item.getId(), item.getScore(), item.getTestingDate()));
                    mismatchDescription.appendText(errMsg.toString());
                    retValue = false;
                } else {
                    retValue = true;
                }
                return retValue;
            }

            @Override
            public void describeTo(Description description) {
                // nothing to append
            }
        };
    }
}
