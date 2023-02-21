package utils.serializers

import basicClasses.Chapter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class ChapterSerializer : KSerializer<Chapter> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Chapter", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Chapter {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Chapter) {
        TODO("Not yet implemented")
    }
}