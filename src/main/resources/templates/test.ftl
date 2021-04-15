<#import "parts/common.ftl" as c>

<@c.page>
    <p style="text-align: center">Кого выберешь ты?</p>
    <div>
        <form action="/test" method="POST">
        <div style="display: inline-block; text-align: center;max-width:500px; max-height:500px">
            <#if cat??>
                <p><img style=" max-width:400px; max-height:400px" src="/img/${cat.filename}"></p>
                <p><a href="/test" style="text-align: center">${cat.name}</a></p>
                <input type="hidden" value="${cat.id}" name="catID"}>
            </#if>
        </div>
        </form>
        <form>
        <div style="display: inline-block; text-align: center; margin-left: 45%; max-width:500px; max-height:500px">
            <#if cat2??>
                <p><img style=" max-width:400px; max-height:400px" src="/img/${cat2.filename}"></p>
                <p><a href="/test" style="text-align: center">${cat2.name}</a></p>
                <input type="hidden" value="${cat2.id}" name="catID"}>
            </#if>
        </div>
        </form>
    </div>
</@c.page>