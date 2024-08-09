const servicesSpace = document.getElementById("services")

api.get("/services")
.then(res => {

    res.data.content.forEach((data) => {
            servicesSpace.insertAdjacentHTML("afterbegin",`<div class="swiper-slide">
                <div class="services-item ">
                    <span class="item__service tag-${data.Employee.name.toLowerCase()}"></span>
                    <p class="item__service-client">${data.Client.name}</p>
                    <p class="item__service-date">${data.date}
                        <span class="date-hours">${data.start}-${data.end}</span>
                    </p>
                </div>
            </div>`)
    });

})

.catch(err => {
    console.error(err); 
})