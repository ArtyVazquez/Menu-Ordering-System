import org.example.BreakfastOrder;
import org.example.ExtractInput;
import org.junit.Assert;
import org.junit.Test;

public class TestBreakfastOrder {

    @Test
    public void testOrder() {
        ExtractInput p = new ExtractInput("Breakfast 1,2,3");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Eggs, Toast, Coffee", bo.place());
    }

    @Test
    public void testOrder2() {
        ExtractInput p = new ExtractInput("Breakfast 2,3,1");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Eggs, Toast, Coffee", bo.place());
    }

    @Test
    public void testOrder3() {
        ExtractInput p = new ExtractInput("Breakfast 1,2,3,3,3");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Eggs, Toast, Coffee(3)", bo.place());
    }

    @Test
    public void testOrder4() {
        ExtractInput p = new ExtractInput("Breakfast 1");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Unable to process: Side is missing", bo.place());
    }

    @Test
    public void testOrder5() {
        ExtractInput p = new ExtractInput("Breakfast 2");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Unable to process: Main is missing", bo.place());
    }

    @Test
    public void testOrder6() {
        ExtractInput p = new ExtractInput("Breakfast 1,2");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Eggs, Toast, Water", bo.place());
    }

    @Test
    public void testOrder7() {
        ExtractInput p = new ExtractInput("Breakfast 1,1,2");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s cannot be ordered more than once", "Eggs"), bo.place());
    }

    @Test
    public void testOrder8() {
        ExtractInput p = new ExtractInput("Breakfast 1,2,2");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s cannot be ordered more than once", "Toast"), bo.place());
    }

    @Test
    public void testOrder9() {
        ExtractInput p = new ExtractInput("Breakfast 3");
        p.extract();
        BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Unable to process: Main is missing, side is missing", bo.place());
    }
}
