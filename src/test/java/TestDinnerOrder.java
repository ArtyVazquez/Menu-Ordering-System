import org.example.DinnerOrder;
import org.example.ExtractInput;
import org.junit.Assert;
import org.junit.Test;

public class TestDinnerOrder {

    @Test
    public void testOrder() {
        ExtractInput p = new ExtractInput("Dinner 1,2,3,4");
        p.extract();
        DinnerOrder d = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(), p.getDesertCount());
        Assert.assertEquals("Steak, Potatoes, Wine, Water, Cake", d.place());
    }

    @Test
    public void testOrder2() {
        ExtractInput p = new ExtractInput("Dinner 1,2,3");
        p.extract();
        DinnerOrder d = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(), p.getDesertCount());
        Assert.assertEquals("Unable to process: Dessert is missing", d.place());
    }

    @Test
    public void testOrder3() {
        ExtractInput p = new ExtractInput("Dinner 1,2,3,4,4");
        p.extract();
        DinnerOrder d = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(), p.getDesertCount());
        Assert.assertEquals(String.format("Unable to process: %s cannot be ordered more than once", "Cake"), d.place());
    }

    @Test
    public void testOrder4() {
        ExtractInput p = new ExtractInput("Dinner");
        p.extract();
        DinnerOrder d = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(), p.getDesertCount());
        Assert.assertEquals("Unable to process: Main is missing, side is missing, desert is missing", d.place());
    }

    @Test
    public void testOrder5() {
        ExtractInput p = new ExtractInput("Dinner 1,3,4");
        p.extract();
        DinnerOrder d = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(), p.getDesertCount());
        Assert.assertEquals("Unable to process: Side is missing", d.place());
    }
}
