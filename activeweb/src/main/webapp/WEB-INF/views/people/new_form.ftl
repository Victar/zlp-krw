<h2>Create new person</h2>

<@form action="create" method ="post">

First name: <input type="text" name="first_name" value="${(request.first_name)!}"/>
<span class="error">${(errors.first_name)!}</span>

<br>
Last name: <input type="text" name="last_name" value="${(request.last_name)!}"/>
<span class="error">${(errors.last_name)!}</span>

<br>
<input type="submit" name="Add new person"/>
</@form>