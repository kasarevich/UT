import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class CheckTriangleGroup {

    Triangle triangle;

    @DataProvider(name = "checkTriangleWithInvalidSizesOfSidesProvider")
    public Object[][] checkTriangleWithInvalidSizesOfSidesData() {
        return new Object[][]{
                {0.0d, 0.0d, 0.0d, "a<=0"},
                {0.0d, 1.0d, 1.0d, "a<=0"},
                {-1d, 2d, 2d, "a<=0"},
                {-2.1d, -2.2d, -2.3d, "a<=0"},
                {2.4d, 0d, 2.5d, "b<=0"},
                {2.6d, -2.7d, 2.8d, "b<=0"},
                {2.9d, 3.0d, 0.0d, "c<=0"},
                {3.1d, 3.2d, -3.3d, "c<=0"},

                {3.4d, 3.5d, 6.9d, "a+b<=c"},
                {3.6d, 3.7d, 7.4d, "a+b<=c"},
                {3.8d, 7.7d, 3.9d, "a+c<=b"},
                {4.0d, 8.2d, 4.1d, "a+c<=b"},
                {8.5d, 4.2d, 4.3d, "b+c<=a"},
                {9.0d, 4.4d, 4.5d, "b+c<=a"},
        };
    }

    @DataProvider(name = "checkTriangleWithSizesOfSidesWhenOverflowCanAppearProvider")
    public Object[][] checkTriangleWithSizesOfSidesWhenOverflowCanAppearData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
        };
    }

    @DataProvider(name = "checkTriangleWithValidSizesOfSidesProvider")
    public Object[][] checkTriangleWithValidSizesOfSidesData() {
        return new Object[][]{
                {4.6d, 4.6d, 8.0d, ""},
                {4.7d, 4.7d, 4.7d, ""},
                {3.0d, 4.0d, 5.0d, ""},
        };
    }

    @Test(dataProvider = "checkTriangleWithInvalidSizesOfSidesProvider")
    public void checkTriangle_invalidSizesOfSides_returnsFalseAndMessage(Double sideA, Double sideB, Double sideC, String expectedMessage){
        triangle = new Triangle(sideA, sideB, sideC);
        Assert.assertFalse(triangle.checkTriangle());
        Assert.assertEquals(triangle.getMessage(), expectedMessage);
    }

    @AfterMethod
    public void afterCheckTriangle_invalidSizesOfSides_returnsFalseAndMessage(){
        triangle = null;
    }

    @Test(expectedExceptions = Exception.class,
            dataProvider = "checkTriangleWithSizesOfSidesWhenOverflowCanAppearProvider")
    public void checkTriangle_tooBigSizesOfSides_overflowException(Double sideA, Double sideB, Double sideC){
        triangle = new Triangle(sideA, sideB, sideC);
        triangle.checkTriangle();
    }

    @AfterMethod
    public void afterCheckTriangle_tooBigSizesOfSides_overflowException(){
        triangle = null;
    }


    @Test(dataProvider = "checkTriangleWithValidSizesOfSidesProvider")
    public void checkTriangle_validSizesOfSides_returnsTrueAndEmptyMessage(Double sideA, Double sideB, Double sideC, String expectedMessage){
        triangle = new Triangle(sideA, sideB, sideC);
        Assert.assertTrue(triangle.checkTriangle());
        Assert.assertEquals(triangle.getMessage(), expectedMessage);
    }

    @AfterMethod
    public void afterCheckTriangle_validSizesOfSides_returnsTrueAndEmptyMessage(){
        triangle = null;
    }

}
