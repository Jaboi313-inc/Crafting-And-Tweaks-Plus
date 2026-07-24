package com.jaboi313.craftingandtweaksplus.recipe;

import com.jaboi313.craftingandtweaksplus.ModItems;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;


public class HarnessDyeingRecipe extends CustomRecipe {


    public HarnessDyeingRecipe() {
        super();
    }


    @Override
    public boolean matches(CraftingInput input, Level level) {

        boolean hasHarness = false;
        boolean hasDye = false;


        for (int i = 0; i < input.size(); i++) {

            ItemStack stack = input.getItem(i);


            if (ModItems.SPEED_HARNESSES.containsValue(stack.getItem())) {
                hasHarness = true;
            }


            if (isDye(stack)) {
                hasDye = true;
            }
        }


        return hasHarness && hasDye;
    }


    @Override
    public ItemStack assemble(CraftingInput input) {

        Item harness = null;
        DyeColor dye = null;


        for (int i = 0; i < input.size(); i++) {

            ItemStack stack = input.getItem(i);


            if (ModItems.SPEED_HARNESSES.containsValue(stack.getItem())) {
                harness = stack.getItem();
            }


            DyeColor found = getDye(stack);

            if (found != null) {
                dye = found;
            }
        }


        if (harness == null || dye == null)
            return ItemStack.EMPTY;

        DyeColor currentColor = getHarnessColor(harness);

        if (currentColor == dye)
            return ItemStack.EMPTY;

        String oldId = BuiltInRegistries.ITEM
                .getKey(harness)
                .getPath();

        String[] parts = oldId.split("_");

        String level = parts[2];


        String newId =
                dye.getName()
                + "_speed_"
                + level
                + "_harness";


        Item result = ModItems.SPEED_HARNESSES.get(newId);


        if (result == null)
            return ItemStack.EMPTY;


        return new ItemStack(result);
    }



    private DyeColor getHarnessColor(Item item) {

        for (var entry : ModItems.SPEED_HARNESSES.entrySet()) {

            if (entry.getValue() == item) {

                String id = entry.getKey();

                String color = id.split("_")[0];

                return DyeColor.byName(color, null);
            }
        }

        return null;
    }



    private boolean isDye(ItemStack stack) {

        return getDye(stack) != null;
    }



    private DyeColor getDye(ItemStack stack) {

        if (stack.is(Items.DYE.black())) return DyeColor.BLACK;
        if (stack.is(Items.DYE.blue())) return DyeColor.BLUE;
        if (stack.is(Items.DYE.brown())) return DyeColor.BROWN;
        if (stack.is(Items.DYE.cyan())) return DyeColor.CYAN;
        if (stack.is(Items.DYE.gray())) return DyeColor.GRAY;
        if (stack.is(Items.DYE.green())) return DyeColor.GREEN;
        if (stack.is(Items.DYE.lightBlue())) return DyeColor.LIGHT_BLUE;
        if (stack.is(Items.DYE.lightGray())) return DyeColor.LIGHT_GRAY;
        if (stack.is(Items.DYE.lime())) return DyeColor.LIME;
        if (stack.is(Items.DYE.magenta())) return DyeColor.MAGENTA;
        if (stack.is(Items.DYE.orange())) return DyeColor.ORANGE;
        if (stack.is(Items.DYE.pink())) return DyeColor.PINK;
        if (stack.is(Items.DYE.purple())) return DyeColor.PURPLE;
        if (stack.is(Items.DYE.red())) return DyeColor.RED;
        if (stack.is(Items.DYE.white())) return DyeColor.WHITE;
        if (stack.is(Items.DYE.yellow())) return DyeColor.YELLOW;

        return null;
    }



    @Override
    public RecipeSerializer<HarnessDyeingRecipe> getSerializer() {
        return ModRecipes.HARNESS_DYEING;
    }


    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}