package modele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGrille {

    private Grille grille;

    @Before
    public void setUp() {
        // Création d'une grille de 5 * 5 = 25 cases
        this.grille = new Grille(5,5);
    }

    @Test
    public void testVerifierNombreCases() {
        System.out.println("testVerifierNombreCases");
        // l'objectif est de véifier que la grille contient bien le nombre de cases désiré.
        Assert.assertEquals(36, grille.getTaille());
    }

}
