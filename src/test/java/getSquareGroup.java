import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class getSquareGroup {

    Triangle triangle;

    @DataProvider(name = "getSquareWithInvalidSizesOfSidesProvider")
    public Object[][] getSquareWithInvalidSizesOfSidesData() {
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

                {6.8d, 6.9d, 13.7d},
                {7.0d, 7.1d, 14.1d},
                {7.2d, 14.5d, 7.3d},
                {7.4d, 15.0d, 7.5d},
                {15.3d, 7.6d, 7.7d},
                {15.8d, 7.8d, 7.9d},
        };
    }

    @DataProvider(name = "getSquarePositiveProvider")
    public Object[][] getSquarePositiveData() {
        return new Object[][]{
                {3.0d, 4.0d, 5.0d},
                {6.0d, 5.0d, 2.0d},
                {10.0d, 15.d, 7.0d},
        };
    }

    @Test(expectedExceptions = Exception.class,
            dataProvider = "getSquareWithInvalidSizesOfSidesProvider")
    public void getSquare_invalidSizes_Exception(Double sideA, Double sideB, Double sideC) {
        triangle = new Triangle(sideA, sideB, sideC);
        triangle.getSquare();
    }

    @AfterMethod
    public void afterGetSquare_invalidSizes_Exception(){
        triangle = null;
    }

    @Test(dataProvider = "getSquarePositiveProvider")
    public void getSquare_validSizes_returnsSquare(Double sideA, Double sideB, Double sideC){
        triangle = new Triangle(sideA, sideB, sideC);
        double p = (sideA + sideB + sideC)/2;
        double square = Math.sqrt(p*(p-sideA)*(p-sideB)*(p - sideC));
        triangle = new Triangle(sideA, sideB, sideC);
        Assert.assertEquals(triangle.getSquare(), square);
    }

    @AfterMethod
    public void afterDetectTriangle_DifferentCombinationsOfSize_returnsExpectedType(){
        triangle = null;
    }
}
