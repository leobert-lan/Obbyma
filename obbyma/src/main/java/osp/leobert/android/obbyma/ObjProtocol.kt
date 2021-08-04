package osp.leobert.android.obbyma

import androidx.collection.SparseArrayCompat


/**
 * <p><b>Package:</b> osp.leobert.android.obbyma </p>
 * <p><b>Project:</b> obbyma </p>
 * <p><b>Classname:</b> ObjProtocol </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/8/3.
 */
open class ObjProtocol<T> : Protocol<T>() {
    private val props = SparseArrayCompat<MutableList<Property<T, *>>>()

    fun append(group: Int, property: Property<T, *>) {
        if (!props.containsKey(group)) {
            props.put(group, arrayListOf())
        }
        props.get(group)?.add(property)

    }

    override fun object2Bytes(group: Int, obj: T, target: IBytesStore, length: Int) {
        val ci = target.getCurrentIndex()

        props.get(group)?.forEach {
            it.write2Store(target, obj)
        }

        val ci2 = target.getCurrentIndex()
        if (ci2 - ci > length) {
            throw IllegalStateException("允许使用$length 位写入，但使用了${ci2 - ci} 位")
        }

        target.moveTo(ci + length)
    }

    override fun bytes2Object(group: Int, obj: T, from: IBytesStore, length: Int) {
        val ci = from.getCurrentIndex()

        props.get(group)?.forEach {
            it.readFromStore(from, obj)
        }

        from.moveTo(ci + length)
    }

}