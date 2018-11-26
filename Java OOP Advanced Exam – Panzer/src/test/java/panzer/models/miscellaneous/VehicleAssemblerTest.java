package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler assembler;

    @Before
    public void setUp() throws Exception {
        this.assembler = new VehicleAssembler();
        this.addThreeItems();
    }

    @Test
    public void getTotalWeight() throws Exception {
        Assert.assertTrue( this.assembler.getTotalWeight() == 3);
    }

    @Test
    public void getTotalPrice() throws Exception {
        Assert.assertTrue(this.assembler.getTotalPrice().equals(new BigDecimal(3)));
    }

    @Test
    public void getTotalAttackModification() throws Exception {
            Assert.assertTrue(this.assembler.getTotalAttackModification() == 1);
    }

    @Test
    public void getTotalDefenseModification() throws Exception {
        Assert.assertTrue(this.assembler.getTotalDefenseModification() == 1);
    }

    @Test
    public void getTotalHitPointModification() throws Exception {
        Assert.assertTrue(this.assembler.getTotalHitPointModification() == 1);
    }

    @Test
    public void addArsenalPart() throws Exception {
        Field field = this.assembler.getClass().getDeclaredField("arsenalParts");
        int size = 0;
                field.setAccessible(true);
                List<AttackModifyingPart> arsenalList = null;

                try {
                    arsenalList = (List<AttackModifyingPart>) field.get(this.assembler);
                    size = arsenalList.size();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

        Assert.assertTrue(size == 1);
    }

 //   private int getListSize(Class<?> annotationListClass) {
 //       Field[] fields = this.assembler.getClass().getDeclaredFields();
 //       int size = 0;
 //       for (Field field : fields) {
 //           if(field.isAnnotationPresent(annotationListClass.class)) {
 //               field.setAccessible(true);
 //               List<AttackModifyingPart> arsenalList = null;
//
 //               try {
 //                   arsenalList = (List<AttackModifyingPart>) field.get(this.assembler);
 //                   size = arsenalList.size();
 //               } catch (IllegalAccessException e) {
 //                   e.printStackTrace();
 //               }
 //           }
 //       }
 //       return size;
 //   }


    @Test
    public void addShellPart() throws Exception {
        Field field = this.assembler.getClass().getDeclaredField("shellParts");
        int size = 0;

                field.setAccessible(true);
                List<DefenseModifyingPart> arsenalList = null;

                try {
                    arsenalList = (List<DefenseModifyingPart>) field.get(this.assembler);
                    size = arsenalList.size();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

        Assert.assertTrue(size == 1);
    }

    @Test
    public void addEndurancePart() throws Exception {
        Field field = this.assembler.getClass().getDeclaredField("enduranceParts");
        int size = 0;

                field.setAccessible(true);
                List<HitPointsModifyingPart> arsenalList = null;

                try {
                    arsenalList = (List<HitPointsModifyingPart>) field.get(this.assembler);
                    size = arsenalList.size();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
        }

        Assert.assertTrue(size == 1);
    }

    private void addThreeItems() {
        AttackModifyingPart arsenalPart = createArsenalPart();
        DefenseModifyingPart shellPart = createShellPart();
        HitPointsModifyingPart endurancePart = createEndurancePart();

        this.assembler.addArsenalPart(arsenalPart);
        this.assembler.addShellPart(shellPart);
        this.assembler.addEndurancePart(endurancePart);
    }

    private AttackModifyingPart createArsenalPart() {
        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part.getWeight()).thenReturn(1.0);
        Mockito.when(part.getPrice()).thenReturn(new BigDecimal(1));
        Mockito.when(part.getAttackModifier()).thenReturn(1);
        return part;
    }
    private DefenseModifyingPart createShellPart() {
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part.getWeight()).thenReturn(1.0);
        Mockito.when(part.getPrice()).thenReturn(new BigDecimal(1));
        Mockito.when(part.getDefenseModifier()).thenReturn(1);
        return part;
    }
    private HitPointsModifyingPart createEndurancePart() {
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part.getWeight()).thenReturn(1.0);
        Mockito.when(part.getPrice()).thenReturn(new BigDecimal(1));
        Mockito.when(part.getHitPointsModifier()).thenReturn(1);
        return part;
    }


}