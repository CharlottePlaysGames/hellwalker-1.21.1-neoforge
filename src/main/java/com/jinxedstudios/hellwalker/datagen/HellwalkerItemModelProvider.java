package com.jinxedstudios.hellwalker.datagen;

import com.jinxedstudios.hellwalker.HellwalkerEngine;
import com.jinxedstudios.hellwalker.items.HellwalkerItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class HellwalkerItemModelProvider extends ItemModelProvider {
   // private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
    }

    public HellwalkerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HellwalkerEngine.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(HellwalkerItems.BLUE_ACCESS_KEY.get());
        basicItem(HellwalkerItems.YELLOW_ACCESS_KEY.get());

        basicItem(HellwalkerItems.DATA_LOG.get());
        basicItem(HellwalkerItems.PRAETOR_TOKEN.get());


        withExistingParent(HellwalkerItems.POSSESSED_SCIENTIST_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(HellwalkerItems.UNWILLING_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

 //   private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
 //       return withExistingParent(item.getId().getPath(),
  ///              ResourceLocation.parse("item/generated")).texture("layer0",
   //             ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID,"block/" + item.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this
 //   private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
  //      final String MOD_ID = HellwalkerEngine.MODID; // Change this to your mod id

      //  if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
      //      trimMaterials.forEach((trimMaterial, value) -> {
      //          float trimValue = value;

        //        String armorType = switch (armorItem.getEquipmentSlot()) {
         //           case HEAD -> "helmet";
         //           case CHEST -> "chestplate";
           //         case LEGS -> "leggings";
          //          case FEET -> "boots";
         //           default -> "";
         //       };

        //        String armorItemPath = armorItem.toString();
        //        String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
         //       String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
          //      ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
         //       ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
         //       ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
          //      existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
        //        getBuilder(currentTrimName)
      //                  .parent(new ModelFile.UncheckedModelFile("item/generated"))
        //                .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
    //                    .texture("layer1", trimResLoc);

    //            // Non-trimmed armorItem file (normal variant)
     //           this.withExistingParent(itemDeferredItem.getId().getPath(),
    //                            mcLoc("item/generated"))
     //                   .override()
     //                   .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
     //                   .predicate(mcLoc("trim_type"), trimValue).end()
     //                   .texture("layer0",
     //                           ResourceLocation.fromNamespaceAndPath(MOD_ID,
     //                                   "item/" + itemDeferredItem.getId().getPath()));
     //       });
    //    }
  //  }

   // public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
   //     this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
    //            .texture("texture",  ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID,
    //                    "block/" + baseBlock.getId().getPath()));
  //  }

  //  public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
  //      this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
//.texture("texture",  ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID,
//                        "block/" + baseBlock.getId().getPath()));
  //  }

   // public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
   //     this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
   //             .texture("wall",  ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID,
  //                      "block/" + baseBlock.getId().getPath()));
   // }

  //  private ItemModelBuilder handheldItem(DeferredItem<?> item) {
   //     return withExistingParent(item.getId().getPath(),
  //              ResourceLocation.parse("item/handheld")).texture("layer0",
  //              ResourceLocation.fromNamespaceAndPath(HellwalkerEngine.MODID,"item/" + item.getId().getPath()));
 //   }
//}