package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 */
public class Chef {

    private final Oven oven;
    private final SousChef sousChef;
    private static final int DEFAULT_INITIAL_TEMPERATURE = 300;

    public Chef(Oven oven, SousChef sousChef) {
        this.sousChef = sousChef;
        this.oven = oven;
    }

    public static void main(String[] args) {
        Oven oven = new Oven(DEFAULT_INITIAL_TEMPERATURE);
        SousChef sousChef = new SousChef(oven);
        Chef chef = new Chef(oven, sousChef);
        PotRoast potRoast = new PotRoast();
        Baguette baguette = new Baguette(0.5);
        Baguette baguetteSecond = new Baguette(0.5);
        RoastedSweetPotato roastedSweetPotato = new RoastedSweetPotato();

        chef.prepareToCook(potRoast);
        chef.prepareToCook(baguette);
        chef.prepareToCook(roastedSweetPotato);
        chef.prepareToCook(baguetteSecond);
    }

    private void prepareToCook(Recipe recipe) {
        this.sousChef.prepare(recipe, new RecipeReadyCallback() {
            @Override
            public void recipeReadyToCook(Recipe recipe) {
                cookInOven(recipe, true);
            }
        });
    }

    private void cookInOven(Recipe recipe, boolean initialPutInOven) {

        if (initialPutInOven) {
	        recipe.initializeFromOven(this.oven);
        }

	    oven.cook(recipe, new Timer() {
            @Override
            public void update(Time unit, int value, int ovenTemperature) {
                recipe.adjust(unit, value, ovenTemperature);
                if (recipe.isRecipeDone()) {
                    oven.takeOut(recipe);
                    return;
                }
                oven.cook(recipe, this, false);
            }
            }, initialPutInOven);
    }
}


