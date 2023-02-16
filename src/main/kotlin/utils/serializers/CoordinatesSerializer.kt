package utils.serializers

import basicClasses.Coordinates
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class CoordinatesSerializer : KSerializer<Coordinates> {
    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    override fun deserialize(decoder: Decoder): Coordinates {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Coordinates) {
        TODO("Not yet implemented")
    }
}