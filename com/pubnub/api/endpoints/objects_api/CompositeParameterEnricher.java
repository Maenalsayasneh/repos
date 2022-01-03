package com.pubnub.api.endpoints.objects_api;

import com.pubnub.api.PubNubException;
import com.pubnub.api.endpoints.objects_api.utils.Filter;
import com.pubnub.api.endpoints.objects_api.utils.Include;
import com.pubnub.api.endpoints.objects_api.utils.Limiter;
import com.pubnub.api.endpoints.objects_api.utils.Pager;
import com.pubnub.api.endpoints.objects_api.utils.ParameterEnricher;
import com.pubnub.api.endpoints.objects_api.utils.Sorter;
import com.pubnub.api.endpoints.objects_api.utils.TotalCounter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class CompositeParameterEnricher implements ParameterEnricher {
    private final Filter filter;
    private final Include include;
    private final Limiter limiter;
    private final Pager pager;
    private final Sorter sorter;
    private final TotalCounter totalCounter;

    public CompositeParameterEnricher(Include include, Sorter sorter, Pager pager, Filter filter, TotalCounter totalCounter, Limiter limiter) {
        this.include = include;
        this.sorter = sorter;
        this.pager = pager;
        this.filter = filter;
        this.totalCounter = totalCounter;
        this.limiter = limiter;
    }

    public static CompositeParameterEnricher createDefault() {
        return new CompositeParameterEnricher(new Include(), new Sorter(), new Pager(), new Filter(), new TotalCounter(), new Limiter());
    }

    @Override // com.pubnub.api.endpoints.objects_api.utils.ParameterEnricher
    public Map<String, String> enrichParameters(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap<>(map);
        ArrayList arrayList = new ArrayList();
        for (ParameterEnricher parameterEnricher : Arrays.asList(this.include, this.sorter, this.pager, this.filter, this.totalCounter, this.limiter)) {
            if (parameterEnricher != null) {
                arrayList.add(parameterEnricher);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashMap = ((ParameterEnricher) it.next()).enrichParameters(hashMap);
        }
        return hashMap;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public Include getInclude() {
        return this.include;
    }

    public Limiter getLimiter() {
        return this.limiter;
    }

    public Pager getPager() {
        return this.pager;
    }

    public Sorter getSorter() {
        return this.sorter;
    }

    public TotalCounter getTotalCounter() {
        return this.totalCounter;
    }

    @Override // com.pubnub.api.endpoints.objects_api.utils.ParameterEnricher
    public void validateParameters() throws PubNubException {
        for (ParameterEnricher parameterEnricher : Arrays.asList(this.include, this.sorter, this.pager, this.filter, this.totalCounter, this.limiter)) {
            parameterEnricher.validateParameters();
        }
    }
}
