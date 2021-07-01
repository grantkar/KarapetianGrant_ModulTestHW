import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunTest {

    @DataProvider
    public Object [][] testAddMeaning(){
        return new Object[][]{
                {10,5,5},
                {-10,-5,-5},
                {-1,-2147483648,2147483647}
        };
    }

    @Test(dataProvider = "testAddMeaning")
    public void testAdd(int result, int num1, int num2){
        Assert.assertEquals(result, SimpleCalculator.calc(num1,num2,'+'));
    }

    @DataProvider
    public Object [][] testAddMeaningFalse(){
        return new Object[][]{
                {15,5,5},
                {-11,-5,-5},
                {1,-2147483648,2147483647}
        };
    }

    @Test(dataProvider = "testAddMeaningFalse")
    public void testAddFalse(int result, int num1, int num2){
        Assert.assertNotEquals(result, SimpleCalculator.calc(num1,num2,'+'));
    }

    @DataProvider
    public Object [][] testSubMeaning(){
        return new Object[][]{
                {10,50,40},
                {-10,5,15},
                {0,2147483647,2147483647}
        };
    }

    @Test(dataProvider = "testSubMeaning")
    public void testSub(int result, int num1, int num2){
        Assert.assertEquals(result, SimpleCalculator.calc(num1,num2,'-'));
    }
    @DataProvider
    public Object [][] testSubMeaningFalse(){
        return new Object[][]{
                {30,50,40},
                {10,5,15},
                {1,2147483647,2147483647}
        };
    }

    @Test(dataProvider = "testSubMeaningFalse")
    public void testSubFalse(int result, int num1, int num2){
        Assert.assertNotEquals(result, SimpleCalculator.calc(num1,num2,'-'));
    }

    @DataProvider
    public Object [][] testMulMeaning(){
        return new Object[][]{
                {6,2,3},
                {-1,-1,1},
                {0,0,0}
        };
    }

    @Test(dataProvider = "testMulMeaning")
    public void testMul(int result, int num1, int num2){
        Assert.assertEquals(result, SimpleCalculator.calc(num1,num2,'*'));
    }

    @DataProvider
    public Object [][] testMulMeaningFalse(){
        return new Object[][]{
                {5,2,3},
                {1,-1,1},
                {100,0,0}
        };
    }

    @Test(dataProvider = "testMulMeaningFalse")
    public void testMulFalse(int result, int num1, int num2){
        Assert.assertNotEquals(result, SimpleCalculator.calc(num1,num2,'*'));
    }

    @DataProvider
    public Object [][] testDivMeaningFalse(){
        return new Object[][]{
                {3,6,3},
                {1,-1,1},
                {100,100,0}
        };
    }

    @Test(dataProvider = "testDivMeaningFalse")
    public void testDivFalse(int result, int num1, int num2){
        try {
            Assert.assertNotEquals(result, SimpleCalculator.calc(num1,num2,'/'));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object [][] testDivMeaning(){
        return new Object[][]{
                {2,6,3},
                {-1,-1,1},
                {100,1000,10}
        };
    }

    @Test(dataProvider = "testDivMeaning")
    public void testDiv(int result, int num1, int num2){
        Assert.assertEquals(result, SimpleCalculator.calc(num1,num2,'/'));
    }
}
