package osp.leobert.android.obbyma

/**
 * <p><b>Package:</b> osp.leobert.android.obbyma </p>
 * <p><b>Project:</b> obbyma </p>
 * <p><b>Classname:</b> Protocol </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/8/3.
 */
abstract class Protocol<T> {

    abstract fun object2Bytes(group: Int, obj: T, target: IBytesStore, length: Int)

    abstract fun bytes2Object(group: Int, obj: T, from: IBytesStore, length: Int)

}