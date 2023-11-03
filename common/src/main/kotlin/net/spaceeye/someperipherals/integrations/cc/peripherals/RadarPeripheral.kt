package net.spaceeye.someperipherals.integrations.cc.peripherals

import dan200.computercraft.api.lua.LuaException
import dan200.computercraft.api.lua.LuaFunction
import dan200.computercraft.api.peripheral.IPeripheral
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.spaceeye.someperipherals.SomePeripheralsCommonBlocks
import net.spaceeye.someperipherals.utils.configToMap.makeRadarConfigInfo
import net.spaceeye.someperipherals.utils.radar.scanInRadius
import kotlin.jvm.Throws

class RadarPeripheral(private val level: Level, private val pos: BlockPos): IPeripheral {
    @LuaFunction
    @Throws(LuaException::class)
    fun scan(radius: Double) = scanInRadius(radius, level, pos)

    @LuaFunction
    fun getConfigInfo() = makeRadarConfigInfo()

    override fun equals(p0: IPeripheral?): Boolean = level.getBlockState(pos).`is`(SomePeripheralsCommonBlocks.RADAR.get())
    override fun getType(): String = "sp_radar"
}