package com.isep.rpg;

public class Healer extends SpellCaster {

    int qtpotionforce = 3;

    int qtpotionvie = 3;
    int qtfood = 5;

    public Healer(String n, int h, int A) {

        super(n, h, A);
    }

    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        }
        else if (item instanceof Food) {
            food = (Food) item;
        }
        else if (item instanceof Potion) {
            potion = (Potion) item;
        }
        else if (item instanceof Armure) {
            armure = (Armure) item;
        }
        else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    @Override
    public void fight(Combatant combatant) {

        combatant.loose(weapon.getDamagePoints());
    }

    public void protectionWin(Combatant combatant) {
        combatant.winarmure(armure.getArmures());
  }

    @Override
    public void Rajouterarrow(Combatant combatant) {

    }
    public void afficherdegatPotionVie(Combatant combatant) {
        System.out.print(" - (" + potion.getVie() + "⚕\uD83D\uDC8A) ");
    }

    public void afficherdegatPotionDegat(Combatant combatant) {
        System.out.print("" + potion.getDamagePoints() + "\uD83D\uDCA5\uD83D\uDCA3) ");
    }

    public void afficherhealFOOD(Combatant combatant) {
        System.out.print(" - (" + food.getvie() + "⚕"+ qtfood +"\uD83C\uDF4F) ");
    }
    @Override
    public void Rajoutermana(Combatant combatant) {

    }

    @Override
    public void afficherdegat(Combatant combatant) {
        System.out.print("" + weapon.getDamagePoints() + "⚕) ");
    }

    @Override
    public void affichermana(Combatant combatant) {

    }

    @Override
    public void afficherfleche(Combatant combatant) {

    }

    public void afficherNBPotionVie(Combatant combatant) {
        System.out.print(qtpotionvie + "\uD83D\uDC8A) ");
    }

    public void afficherNBPotionDegat(Combatant combatant) {
        System.out.print(qtpotionforce + "\uD83D\uDCA3) ");
    }

    public void protectionLoose(Combatant combatant) {
        if (getArmures()>10){
            combatant.loosearmure(10);
            System.out.println("Très bien, vous êtes protégé, il vous reste encore " + getArmures() + " armures ");
        } else if (getArmures()>1){
            int reste = 10-getArmures();
            System.out.println("Vous n'avez pas assée d'armure, il vous manque " + reste + " armures pour pouvoir vous protégez \nVous encaissez pas conséquent "+getArmures()+" points de dégat");
            combatant.loose(getArmures());
        } else {
            System.out.println("Malheuresement vous n'avez plus d'armure, pour pouvoir vous protégez \nVous encaissez pas conséquent 5 points de dégat");
            combatant.loose(5);
        }
    }

    private Armure armure;

    private Weapon weapon;

    public void manger(Combatant combatant) {
        if(qtfood > 0) {
            qtfood = qtfood -1 ;
            combatant.win(food.getvie());
            System.out.println("Il vous reste " + qtfood +" pommes disponibles.");
        } else if(qtfood<=0){
            System.out.println("Désolé, vous n'avez plus de pomme à votre disposition");
        }
    }

    public void heal(Combatant combatant) {
        combatant.win(weapon.getDamagePoints());
    }
    public void afficherdegatNBPotionVie(Combatant combatant) {
        System.out.print(" - (" + potion.getVie() + "⚕"+ qtpotionvie + "\uD83D\uDC8A) ");
    }

    public void afficherdegatNBPotionDegat(Combatant combatant) {
        System.out.print("" + potion.getDamagePoints() + "\uD83D\uDCA5"+ qtpotionforce +"\uD83D\uDCA3) ");
    }

    private Food food;

    public void PotionVie(Combatant combatant) {
            if(qtpotionvie > 0) {
                qtpotionvie = qtpotionvie -1 ;
                combatant.win(potion.getVie());
                System.out.println("Il vous reste " + qtpotionvie +" Potion de vie disponible.");
            } else if(qtpotionvie<=0){
                System.out.println("Désolé, vous n'avez plus de potion de vie à votre disposition");
            }
    }

    public void PotionForce(Combatant combatant) {
        if(qtpotionforce>0 ) {
            qtpotionforce = qtpotionforce - 1;
            combatant.loose(potion.getDamagePoints());
            System.out.println("Il vous reste " + qtpotionforce +" Potion de force disponible.");
        } else if(qtpotionforce<=0){
            System.out.println("Désoler, vous n'avez plus de potion de dégat à votre disposition");
        }
    }

    public void RajouterPotionVie(Combatant combatant){
        qtpotionvie = qtpotionvie + 2;
    }


    public void RajouterPotionDegat(Combatant combatant){
        qtpotionforce = qtpotionforce + 2;
    }


    private Potion potion;
}
