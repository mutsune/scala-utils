package com.mutsune.util.io.File

import java.io.{File, FileNotFoundException, PrintStream, PrintWriter}

import scala.io.Source

/**
  * Created by nakayama.
  */
object FileOps {

    def getFilesFromDir(path: String): Array[File] = getFilesFromDir(new File(path))

    def getFilesFromDir(file: File): Array[File] = {
        if (!file.exists()) throw new FileNotFoundException(file.getAbsolutePath)
        assume(file.isDirectory, file.getAbsolutePath + " is not a directory.")
        file.listFiles()
    }

    def getText(file: File): String = {
        try {
            Source.fromFile(file).getLines.mkString("\n")
        } catch {
            case e: Throwable => throw e
        }
    }

    def withMakeParentDirs(path: String): File = withMakeParentDirs(new File(path))

    def withMakeParentDirs(file: File): File = {
        file.getParent match {
            case null =>
            case p => new File(p).mkdirs()
        }
        file
    }

    def getPrintStream(path: String): PrintStream = getPrintStream(new File(path))

    def getPrintStream(file: File): PrintStream = new PrintStream(withMakeParentDirs(file))

    def writeWithMakeParentDirs(file: File)(op: PrintWriter => Unit): Unit =
        write(new PrintStream(withMakeParentDirs(file)))(op)

    def write(file: File)(op: PrintWriter => Unit): Unit =
        write(new PrintStream(file))(op)

    def write(pstream: PrintStream)(op: PrintWriter => Unit): Unit = {
        val writer = new PrintWriter(pstream)
        try op(writer) finally writer.close()
    }

    def delete(f: File): Unit = {
        if (f.isFile) f.delete()
        else if (f.isDirectory) {
            f.listFiles().foreach(delete)
            f.delete()
        }
    }

}
