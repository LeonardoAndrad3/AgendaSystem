const getEmployes = () => api.get("/employees",{
    headers:{
        'Authorization': 'Bearer ' + sessionStorage.getItem("user")
    },
}).then(e =>{
    const data = e.data
}).catch(e =>{
    console.log(e)
})

getEmployes()