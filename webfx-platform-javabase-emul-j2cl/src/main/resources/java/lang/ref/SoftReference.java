/*
 *  Copyright 2014 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package java.lang.ref;

/**
 * @author Bruno Salmon
 */
public class SoftReference<T> extends Reference<T> {
    private T value;

    public SoftReference(T value) {
        this.value = value;
    }

    public SoftReference(T value, @SuppressWarnings("unused") ReferenceQueue<T> queue) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void clear() {
        value = null;
    }
}
