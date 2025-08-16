package org.example.Revision;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockingMech {


    ReadWriteLock readWriteLock=new ReentrantReadWriteLock(true);
}
