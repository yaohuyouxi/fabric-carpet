package carpet.mixins.blaze;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BasaltDeltasBiome;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BasaltDeltasBiome.class)
public class BasaltDeltasBiomeMixin extends Biome
{

    protected BasaltDeltasBiomeMixin(Settings settings)
    {
        super(settings);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addBlaze(CallbackInfo ci)
    {
        addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.BLAZE, 50, 4, 4));
    }
}