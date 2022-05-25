import org.example.ExtractInput;
import org.example.LunchOrder;
import org.junit.Assert;
import org.junit.Test;

public class TestLunchOrder {

    @Test
    public void testOrder() {
        ExtractInput p = new ExtractInput("Lunch 1,2,3");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Sandwich, Chips, Soda", l.place());
    }

    @Test
    public void testOrder2() {
        ExtractInput p = new ExtractInput("Lunch 1,2");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Sandwich, Chips, Water", l.place());
    }

    @Test
    public void testOrder3() {
        ExtractInput p = new ExtractInput("Lunch 1,1,2,3");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s cannot be ordered more than once", "Sandwich"), l.place());
    }

    @Test
    public void testOrder4() {
        ExtractInput p = new ExtractInput("Lunch 1,2,2");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Sandwich, Chips(2), Water", l.place());
    }

    @Test
    public void testOrder5() {
        ExtractInput p = new ExtractInput("Lunch");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals("Unable to process: Main is missing, side is missing", l.place());
    }

    @Test
    public void testOrder6() {
        ExtractInput p = new ExtractInput("Lunch 1,2,2,3,3");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s cannot be ordered more than once", "Soda"), l.place());
    }

    @Test
    public void testOrder7() {
        ExtractInput p = new ExtractInput("Lunch 1");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s is missing", "Side"), l.place());
    }

    @Test
    public void testOrder8() {
        ExtractInput p = new ExtractInput("Lunch 2,3");
        p.extract();
        LunchOrder l = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
        Assert.assertEquals(String.format("Unable to process: %s is missing", "Main"), l.place());
    }
}
