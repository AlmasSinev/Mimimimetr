<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list cats as cat>
            <div class="card my-3" style="max-width: 400px;">
                <#if cat.filename??>
                    <img class="card-img-top"  src="/img/${cat.filename}"
                </#if>
                <div class="card-body">
                    <h5 class="card-title">${cat.name}</h5>
                    <span class="card-text">Место: №</span>
                    <i style="color: rgba(23,23,23,0.66); text-align: right; margin-left: 5px;">Голосов: ${cat.voicesCount}</i>
                </div>
            </div>
        <#else>
            Нет котиков(
        </#list>
    </div>
</@c.page>