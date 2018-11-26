import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class DetectTriangleGroup {

    Triangle triangle;

    @DataProvider(name = "detectTriangleWithInvalidSizesOfSidesProvider")
    public Object[][] detectTriangleWithInvalidSizesOfSidesData() {
        return new Object[][]{
                {0.0d, 0.0d, 0.0d},
                {0.0d, 5.0d, 5.1d},
                {-5.2d, 5.3d, 5.4d},
                {-5.5d, -5.6d, -5.7d},
                {5.8d, 0d, 5.9d},
                {6.0d, -6.1d, 6.2d},
                {6.3d, 6.4d, 0.0d},
                {6.5d, 6.6d, -6.7d},

                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},

                {6.8d, 6.9d, 13.7d},  // сумма a + b равна c
                {7.0d, 7.1d, 14.1d},  // сумма a + b меньше c
                {7.2d, 14.5d, 7.3d},  // сумма a + c равна b
                {7.4d, 15.0d, 7.5d},  // сумма a + c меньше b
                {15.3d, 7.6d, 7.7d},  // сумма b + c равна a
                {15.8d, 7.8d, 7.9d},  // сумма b + c меньше a
        };
    }

    @DataProvider(name = "detectTriangleWithDifferentCombinationsOfSizeProvider")
    public Object[][] detectTriangleWithDifferentCombinationsOfSizeData() {
        return new Object[][]{
                {3.0d, 4.0d, 5.0d, 8},                              // прямоугольный
                {(Math.sqrt(2.0d)), (Math.sqrt(2.0d)), 2.0d, 10},   // прямоугольный равнобедренный
                {3.0d, 3.0d, 3.0d, 3},                              // равносторонний [равнобедренный]
                {3.0d, 3.0d, 3.1d, 2},                              // равнобедренный

                {3.0d, 3.1d, 3.2d, 4},                               // обычные на граничных значениях
                {4.0d, 4.1d, 4.2d, 4},
                {3.0d, 4.0d, 5.1d, 4},
        };
    }

    @Test(expectedExceptions = Exception.class,
            dataProvider = "detectTriangleWithInvalidSizesOfSidesProvider")
    public void detectTriangle_invalidSizesOfSides_Exception(Double sideA, Double sideB, Double sideC){
        triangle = new Triangle(sideA, sideB, sideC);
        triangle.detectTriangle();
    }

    @AfterMethod
    public void afterDetectTriangle_invalidSizesOfSides_Exception(){
        triangle = null;
    }

    @Test(dataProvider = "detectTriangleWithDifferentCombinationsOfSizeProvider")
    public void detectTriangle_DifferentCombinationsOfSize_returnsExpectedType(Double sideA, Double sideB, Double sideC, int typeOfTriangle){
        triangle = new Triangle(sideA, sideB, sideC);
        Assert.assertEquals(triangle.detectTriangle(), typeOfTriangle, 0.00000000000000000001);
    }

    @AfterMethod
    public void afterDetectTriangle_DifferentCombinationsOfSize_returnsExpectedType(){
        triangle = null;
    }
}
