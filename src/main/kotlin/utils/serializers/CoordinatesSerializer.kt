package utils.serializers

import basicClasses.Coordinates
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class CoordinatesSerializer : KSerializer<Coordinates> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Coordinates", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Coordinates {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Coordinates) {
        TODO("Not yet implemented")
    }
}