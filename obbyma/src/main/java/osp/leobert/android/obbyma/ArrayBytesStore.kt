package osp.leobert.android.obbyma

/**
 * ArrayBytesStore desc: use [ByteArray] to store encoded bytes
 *
 * Created by leobert on 2021/8/3.
 */
class ArrayBytesStore(val data: ByteArray) : IBytesStore {

    private var index = 0

    override fun getCurrentIndex(): Int {
        return index
    }

    override fun write(byte: Byte) {
        data[index] = byte
        index++
    }

    override fun read(): Byte {
        return data[index++]
    }

    override fun moveTo(index: Int) {
        this.index = index
    }

    override fun toString(): String {
        return "ArrayBytesStore(data=${data.contentToString()}, index=$index)"
    }


}