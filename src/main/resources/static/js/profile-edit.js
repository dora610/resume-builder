const addSkillBtn = document.querySelector(".addskill");
const skillsTable = document.querySelector(".skills");
const deleteSkillBtn = document.querySelector(".deleteSkill");
addSkillBtn.addEventListener("click", () => console.log("adding skill"));

const deleteSkill = (e) => {
  let index = e.target.dataset.index;
  console.log(index);

  fetch(`/delete?type=skill&index=${index}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => console.log(data))
    .catch((err) => console.error(err));
};

skillsTable.addEventListener("click", deleteSkill);
