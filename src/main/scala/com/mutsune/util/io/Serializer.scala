package com.mutsune.util.io

import java.io._

import com.mutsune.util.io.File.FileOps

import scala.util.control.Exception._

/**
  * Created by nakayama.
  */
object Serializer {

    def load[T](path: String): T = load[T](new File(path))

    def load[T](file: File): T = {
        val fis = allCatch either new FileInputStream(file) match {
            case Right(x) => x
            case Left(e) => throw e
        }
        val ois = new ObjectInputStream(fis)
        var readObject: AnyRef = null
        try {
            readObject = ois.readObject()
        } finally {
            ois.close()
        }
        readObject.asInstanceOf[T]
    }

    def save(instance: Any, path: String): Unit =
        save(instance, FileOps.withMakeParentDirs(path))

    def save(instance: Any, file: File): Unit = {
        val oos = new ObjectOutputStream(new FileOutputStream(FileOps.withMakeParentDirs(file)))
        try {
            oos.writeObject(instance)
        } finally {
            oos.close()
        }
    }

}
