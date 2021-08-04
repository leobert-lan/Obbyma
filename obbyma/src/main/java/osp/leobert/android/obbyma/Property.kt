package osp.leobert.android.obbyma

import java.lang.reflect.Field

/**
 * <p><b>Package:</b> osp.leobert.android.obbyma </p>
 * <p><b>Project:</b> obbyma </p>
 * <p><b>Classname:</b> Property </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/8/3.
 */
class Property<H, F>(
    val host: Class<H>,
    val group: Int = 0,
    val ordinal: Int,
    private val type: Class<F>,
    val name: String,
    val length: Int = 1,
    val mapper: BasicMapper<F>,
) {

    private val field: Field = host.getDeclaredField(name).apply {
        this.isAccessible = true
    }

    private fun read(obj: H): F? {
        return type.cast(field.get(obj))
    }

    private fun write(obj: H, value: F?) {
        field.set(obj, value)
    }


    fun write2Store(store: IBytesStore, obj: H) {
        mapper.object2Bytes(read(obj), store, length)
    }

    fun readFromStore(store: IBytesStore, obj: H) {
        write(obj, mapper.bytes2Object(store, length))
    }
}