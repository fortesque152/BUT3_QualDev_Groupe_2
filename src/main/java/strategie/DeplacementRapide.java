package strategie;

/** Une commande A fait progresser de deux cases ; rotations identiques. */
public class DeplacementRapide extends DeplacementStandard {
    @Override
    protected int nombreCasesParAvance() {
        return 2;
    }
}
