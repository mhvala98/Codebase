let userScore = 0;
let computerScore = 0;
const userScore_span = document.getElementById("user-score");
const computerScore_span = document.getElementById("computer-score");
const scoreBoard_div = document.querySelector(".score-board");
const result_p = document.querySelector(".result > p");
const rock_div = document.getElementById("rock");
const paper_div = document.getElementById("paper");
const scissors_div = document.getElementById("scissors");

let abbrivationMap =  new Map();
abbrivationMap["r"]="rock";
abbrivationMap["p"]="paper";
abbrivationMap["s"]="scissors";


function getComputerChoice(){
    const choice = ["r","p","s"];
    const randomNumber = Math.floor(Math.random()*3); 
    return choice[randomNumber];
}


function convertToWord(choice){
    if(choice=="r") return "Rock";
    if(choice=="p") return "Paper";
    return "Scissors"
}

function win(userChoice,computerChoice){
    userScore++;
    userScore_span.innerHTML=userScore;
    computerScore_span.innerHTML=computerScore;
    result_p.innerHTML=`${convertToWord(userChoice)} beats ${convertToWord(computerChoice)}. You win...!!`;
    document.getElementById(abbrivationMap[userChoice]).classList.add("green-glow");
    setTimeout(function(){
        document.getElementById(abbrivationMap[userChoice]).classList.remove("green-glow");
    },750);
}

function lose(userChoice,computerChoice){
    computerScore++;
    userScore_span.innerHTML=userScore;
    computerScore_span.innerHTML=computerScore;
    result_p.innerHTML=`${convertToWord(computerChoice)} beats ${convertToWord(userChoice)}. You Lose...!!`;
    document.getElementById(abbrivationMap[userChoice]).classList.add("red-glow");
    setTimeout(function(){
        document.getElementById(abbrivationMap[userChoice]).classList.remove("red-glow");
    },750);
}

function draw(userChoice,computerChoice){
    result_p.innerHTML=`${convertToWord(computerChoice)} equals ${convertToWord(userChoice)}. It's Draw...!!`;
    document.getElementById(abbrivationMap[userChoice]).classList.add("grey-glow");
    setTimeout(function(){
        document.getElementById(abbrivationMap[userChoice]).classList.remove("grey-glow");
    },750);
}

function game(userChoice){
    const computerChoice =  getComputerChoice();
    switch(userChoice+computerChoice){
        case "rs" :
        case "sp" :
        case "pr" :
            win(userChoice,computerChoice);
            break;
        case "sr" :
        case "rp" :
        case "ps" :
            lose(userChoice,computerChoice);
            break;
        case "rr" :
        case "pp" :
        case "ss" :
            draw(userChoice,computerChoice);
            break;
    }
}

function main(){
    rock_div.addEventListener("click",function(){
        game("r")
    });

    paper_div.addEventListener("click",function(){
        game("p")
    });

    scissors_div.addEventListener("click",function(){
        game("s")
    });
}

main();