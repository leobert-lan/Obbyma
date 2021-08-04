package osp.leobert.android.obbyma

/**
 * IBytesStore desc: store of the encoded bytes
 *
 * Created by leobert on 2021/8/3.
 */
interface IBytesStore {
    fun getCurrentIndex(): Int
    fun write(byte: Byte)
    fun read(): Byte

    fun moveTo(index: Int)
}