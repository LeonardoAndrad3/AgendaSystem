
const form = document.getElementById("form__login");
const body = document.getElementById("body");
const agenda = document.getElementById("agenda");

form.addEventListener('submit',(e)=>{
    e.preventDefault();
    postLogin(e.target[0].value, e.target[1].value);
})

const postLogin = (email, password) => {
        api.post('/login', {

            headers:{
                'Content-Type': 'application/json',
            },

            email: email,
            password: password
            
    }).then(resp =>{    

        var date = new Date()

        date.setHours(date.getHours()+2)

        sessionStorage.setItem("user", resp.data.token)

        window.location.replace("/web/routes/agenda/")

    })
    .catch(err => console.log(err))
}