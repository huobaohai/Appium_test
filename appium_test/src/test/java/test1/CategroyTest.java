package test1;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses(peopleTest.class)
@Categories.IncludeCategory(AttributeFun.class)
public class CategroyTest {

}


