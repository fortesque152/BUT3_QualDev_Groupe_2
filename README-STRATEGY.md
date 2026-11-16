# Tondeuse — Design Pattern Strategy

## Modifications

- `IRobot` expose `getStrategieDeplacement()`.
- `RobotManager` est le **contexte** : il délègue la commande à la stratégie de son robot.
- `StrategieDeplacement` est l'interface du pattern.
- `DeplacementStandard` conserve `A` = avancer d'une case, `G` et `D` = tourner de 90°.
- `DeplacementRapide` donne `A` = avancer de deux cases. Les rotations sont inchangées.
- `Tondeuse` porte le **paramètre** `EModeDeplacement` (`STANDARD` ou `RAPIDE`). Le constructeur historique conserve STANDARD par défaut. `setModeDeplacement(...)` permet un changement pendant l'exécution.
- `Grille.getCase` vérifie explicitement les limites de la grille, y compris les coordonnées négatives.

## Architecture

```text
RobotManager ----> IRobot <---- Tondeuse
                       |               |
                       |               +-- EModeDeplacement
                       v
                StrategieDeplacement (interface)
                       ^
                       |
               DeplacementStandard
                       ^
                       |
                DeplacementRapide
```

Le gestionnaire ignore la logique de mouvement : il délègue à l'objet `StrategieDeplacement` fourni par le robot.

## Exécuter

- Projet Maven Java 8+.
- `mvn test` : exécute `TestTondeuse` et `TestGrille` avec JUnit 4.
- `mvn exec:java -Dexec.mainClass=start.DemarreTondeuse` (si le plugin exec Maven est disponible), ou exécuter `DemarreTondeuse.main()` depuis IntelliJ.

## Scénarios couverts

- Deux scénarios historiques préservés.
- Même commande A : une case en STANDARD, deux en RAPIDE.
- Changement de stratégie pendant l'exécution sans remplacer le manager.
- Rotations identiques, quel que soit le mode.
- Sortie de grille : exception et position conservée, y compris côté négatif.
- Validation d'un mode `null`.
