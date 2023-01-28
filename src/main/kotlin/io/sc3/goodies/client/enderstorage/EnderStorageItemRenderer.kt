package io.sc3.goodies.client.enderstorage

import io.sc3.goodies.client.enderstorage.EnderStorageBlockEntityRenderer.Companion.renderChest
import io.sc3.goodies.enderstorage.Frequency
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack
import net.minecraft.util.math.Direction

object EnderStorageItemRenderer : DynamicItemRenderer {
  private val defaultFrequency = Frequency()

  override fun render(stack: ItemStack, mode: ModelTransformation.Mode, matrices: MatrixStack,
                      vertexConsumers: VertexConsumerProvider, light: Int, overlay: Int) {
    val frequency = Frequency.fromStack(stack) ?: defaultFrequency
    val changesEnabled = stack.getSubNbt("BlockEntityTag")?.getBoolean("computerChangesEnabled") ?: false
    renderChest(matrices, vertexConsumers, Direction.NORTH, 0.0f, frequency, changesEnabled, light, overlay)
  }
}
