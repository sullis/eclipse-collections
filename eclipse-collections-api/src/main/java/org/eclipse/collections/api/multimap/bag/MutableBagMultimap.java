/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.multimap.bag;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.tuple.Pair;

/**
 * @since 1.0
 */
public interface MutableBagMultimap<K, V>
        extends MutableBagIterableMultimap<K, V>, UnsortedBagMultimap<K, V>
{
    @Override
    MutableBag<V> replaceValues(K key, Iterable<? extends V> values);

    @Override
    MutableBag<V> removeAll(Object key);

    @Override
    MutableBagMultimap<K, V> newEmpty();

    @Override
    MutableBag<V> get(K key);

    @Override
    MutableBag<V> getIfAbsentPutAll(K key, Iterable<? extends V> values);

    void putOccurrences(K key, V value, int occurrences);

    @Override
    MutableBagMultimap<V, K> flip();

    @Override
    MutableBagMultimap<K, V> selectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableBagMultimap<K, V> rejectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableBagMultimap<K, V> selectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    MutableBagMultimap<K, V> rejectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    <K2, V2> MutableBagMultimap<K2, V2> collectKeysValues(Function2<? super K, ? super V, Pair<K2, V2>> function);

    @Override
    <K2, V2> MutableBagMultimap<K2, V2> collectKeyMultiValues(Function<? super K, ? extends K2> keyFunction, Function<? super V, ? extends V2> valueFunction);

    @Override
    <V2> MutableBagMultimap<K, V2> collectValues(Function<? super V, ? extends V2> function);

    @Override
    MutableBagMultimap<K, V> asSynchronized();
}
