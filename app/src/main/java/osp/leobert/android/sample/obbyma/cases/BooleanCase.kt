package osp.leobert.android.sample.obbyma.cases

import android.util.Log
import osp.leobert.android.obbyma.ArrayBytesStore
import osp.leobert.android.obbyma.ObjProtocol
import osp.leobert.android.obbyma.Property
import osp.leobert.android.obbyma.bm.BooleanMapper

/**
 * BooleanCase desc: TODO
 *
 * Created by leobert on 2021/8/4.
 */
class BooleanCase : TestCase() {

    class A {
        var b: Boolean = false
        override fun toString(): String {
            return "A(b=$b)"
        }
    }

    class AProtocol : ObjProtocol<A>() {
        companion object {
            val prop_b = Property(A::class.java, 0, 0, Boolean::class.javaObjectType, "b", 1, BooleanMapper())
        }

        init {
            append(0, prop_b)
        }
    }

    var i = false

    override fun startCase() {
        try {
            val a = A().apply {
                this.b = i
            }
            i = i.not()
            Log.e("xxx", "${Boolean::class.java},${Boolean::class.javaObjectType}，${Boolean::class.javaPrimitiveType}")

            Log.e("xxx", "a:$a")
            val protocol = AProtocol()
            val store = ArrayBytesStore(ByteArray(5))

            protocol.object2Bytes(0, a, store, 5)
            Log.e("xxx", "store:$store")
            store.moveTo(0)
            val b = A()
            protocol.bytes2Object(0, b, store, 5)
            Log.e("xxx", "b:$b")
        } catch (e: Exception) {
            Log.e("xxx", "", e)
        }
    }
}