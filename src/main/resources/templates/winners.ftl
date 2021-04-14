<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list cats as cat>
            <div class="card my-3">
                <#if cat.filename??>
                    <img class="card-img-top" src="/img/${cat.filename}"
                </#if>
                <span>${cat.name}</span>
                <i style="color: rgba(23,23,23,0.66); text-align: right; margin-left: 5px;">Место: № ${cat.position}</i>
                <div class="card-footer text-muted" style="text-align: right; ">
                    Голосов: ${cat.voicesCount}
                </div>
            </div>
        <#else>
            Нет котиков(
        </#list>
    </div>
</@c.page>