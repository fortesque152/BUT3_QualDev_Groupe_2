import modele.Grille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGrille {
    private Grille grille;

    @Before
    public void setUp() {
        //Initialise une grille
        this.grille = new Grille (5, 5);

    }

    @Test
    public void testVerifieNbCase(){
        //Vérifier qu'on a bien le bon nombre de case
        Assert.assertEquals(36,grille.getTaille());
    }

}
