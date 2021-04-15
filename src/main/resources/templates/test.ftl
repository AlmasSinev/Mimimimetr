<#import "parts/common.ftl" as c>

<@c.page>
    <p style="text-align: center">Кого выберешь ты?</p>
    <div>

        <div style="display: inline; text-align: center;max-width:500px; max-height:500px">
            <form action="/test" method="POST">
            <#if cat??>
                <p><img style=" max-width:400px; max-height:400px" src="/img/${cat.filename}"></p>
                <p><a href="/test" style="text-align: center">${cat.name}</a></p>
                <input type="hidden" value="${cat.id}" name="catID"}>
            </#if>
            </form>
        </div>

        <div style="display: inline; text-align: center; margin-left: 45%; max-width:500px; max-height:500px">
            <form action="/test2" method="POST">
            <#if cat2??>
                <p><img style=" max-width:400px; max-height:400px" src="/img/${cat2.filename}"></p>
                <p><a href="/test" style="text-align: center">${cat2.name}</a></p>
                <input type="hidden" value="${cat2.id}" name="catID"}>
            </#if>
            </form>
        </div>
    </div>
</@c.page>