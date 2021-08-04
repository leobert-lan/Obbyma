package osp.leobert.android.obbyma.bm

import osp.leobert.android.obbyma.BasicMapper
import osp.leobert.android.obbyma.IBytesStore

/**
 * internal impl of BasicMapper for [Boolean]:
 *
 * * when encode: 1 for true, 0 for else cases
 * * when decode: 1 for true, else for false
 *
 * Created by leobert on 2021/8/3.
 */
class BooleanMapper : BasicMapper<Boolean>() {

    override fun object2Bytes(obj: Boolean?, target: IBytesStore, length: Int) {
        val ci = target.getCurrentIndex()
        target.write(if (obj == true) 1 else 0)
        target.moveTo(ci + length)
    }

    override fun bytes2Object(from: IBytesStore, length: Int): Boolean? {
        return (0 until length).map {
            from.read()
        }.firstOrNull()?.run {
            when (this.toInt()) {
                1 -> true
                else -> false
            }
        } ?: false
    }
}