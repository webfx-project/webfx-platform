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
package emul.java.lang.ref;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Bruno Salmon
 */
public class WeakReference<T> extends Reference<T> {
    private JavaScriptObject weakRef;

    public WeakReference(T value) {
        weakRef = createWeakRef(value);
    }

    public WeakReference(T value, @SuppressWarnings("unused") ReferenceQueue<T> queue) {
        weakRef = createWeakRef(value);
    }

    @Override
    public T get() {
        return weakRef == null ? null : (T) getWeakRefValue(weakRef);
    }

    @Override
    public void clear() {
        weakRef = null;
    }

    public static native JavaScriptObject createWeakRef(Object value) /*-{
        try {
            return new WeakRef(value);
        } catch (err) { // For browsers that don't support WeakRef
            return value; // we just return the direct value instead
        }
    }-*/;

    public static native Object getWeakRefValue(JavaScriptObject weakRef) /*-{
        try {
            return weakRef.deref();
        } catch (err) { // For browsers that don't support WeakRef
            return weakRef; // the passed object was actually the value
        }
    }-*/;

}
