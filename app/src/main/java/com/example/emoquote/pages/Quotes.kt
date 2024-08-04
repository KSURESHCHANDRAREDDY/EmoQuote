package com.example.emoquote.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.emoquote.AuthViewModel
import com.example.emoquote.R


data class quotedata(val author:String,val quote:String);

@Composable
fun Happy(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val happinessList = listOf(
        quotedata("-Audrey Hepburn", "The most important thing is to enjoy your life – to be happy. It’s all that matters."),
        quotedata("-Ralph Waldo Emerson", "Nothing can bring you happiness but yourself."),
        quotedata("-Mark Twain", "Never regret anything that made you smile."),
        quotedata("-Kurup", "Today I will focus on stressing less and feeling blessed."),
        quotedata("-Drew Barrymore", "Happiness is the best makeup."),
        quotedata("-Dalai Lama", "Happiness is not something ready made. It comes from your own actions."),
        quotedata("-Eleanor Roosevelt", "Happiness is not a goal; it is a by-product."),
        quotedata("-William James", "The greatest weapon against stress is our ability to choose one thought over another."),
        quotedata("-Confucius", "Happiness depends upon ourselves."),
        quotedata("-Helen Keller", "Happiness cannot come from without. It must come from within."),
        quotedata("-John Lennon", "Happiness is just how you feel when you don't feel miserable."),
        quotedata("-Abraham Lincoln", "Most people are about as happy as they make up their minds to be."),
        quotedata("-Mahatma Gandhi", "Happiness is when what you think, what you say, and what you do are in harmony."),
        quotedata("-Oscar Wilde", "To be happy, we must not be too concerned with others."),
        quotedata("-Franklin D. Roosevelt", "The only limit to our realization of tomorrow is our doubts of today."),
        quotedata("-Thich Nhat Hanh", "There is no way to happiness – happiness is the way."),
        quotedata("-Mother Teresa", "If you want to make the world a better place, take a look at yourself and make a change."),
        quotedata("-Marilyn Monroe", "We are all of us stars, and we deserve to twinkle."),
        quotedata("-Jean-Paul Sartre", "Happiness is not an ideal of reason, but of imagination."),
        quotedata("-Albert Schweitzer", "Success is not the key to happiness. Happiness is the key to success.")
    )

    val randomQuotes = happinessList.shuffled().take(5)

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        item {
            Row {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }
        }

        items(randomQuotes.size) { index ->
            val item = randomQuotes[index]
            Card(
                modifier = Modifier
                    .width(500.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(18.dp)
                    .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, color = Color.Red)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.light),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .scale(7f)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = item.quote,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraLight
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = item.author,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            }
      }
}



@Composable
fun Sad(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val sadList = listOf(
        quotedata("-Audrey Hepburn", "Trust takes years to build, seconds to break, and forever to repair."),
        quotedata("-Ralph Waldo Emerson", "A relationship without trust is like a car with no gas; you can stay in it all you want, but it won't go anywhere."),
        quotedata("-Mark Twain", "I will forgive, but I won't forget. And I hope you know you've lost my respect."),
        quotedata("-Kurup", "Don’t trust too much, don’t love too much, don’t hope too much, because that too much can hurt so much."),
        quotedata("-Drew Barrymore", "We must understand that sadness is an ocean, and sometimes we drown, while other days we are forced to swim."),
        quotedata("-Albert Camus", "In the depth of winter, I finally learned that within me there lay an invincible summer."),
        quotedata("-Emily Dickinson", "The heart wants what it wants—or else it does not care."),
        quotedata("-Eleanor Roosevelt", "The future belongs to those who believe in the beauty of their dreams."),
        quotedata("-John Green", "It's okay to be sad, it's okay to grieve, it's okay to let it all out."),
        quotedata("-Khalil Gibran", "Sadness is but a wall between two gardens."),
        quotedata("-Sylvia Plath", "I have been bent and broken, but—I hope—into a better shape."),
        quotedata("-F. Scott Fitzgerald", "I wasn't actually lonely. I just had a melancholy feeling."),
        quotedata("-Stephen King", "Sadness is a state of mind, but also a form of inspiration."),
        quotedata("-Rainer Maria Rilke", "The only journey is the one within."),
        quotedata("-Virginia Woolf", "I am rooted, but I flow."),
        quotedata("-Oscar Wilde", "Experience is simply the name we give our mistakes."),
        quotedata("-Pablo Neruda", "Laughter is the most beautiful and beneficial therapy God ever granted humanity."),
        quotedata("-Haruki Murakami", "Pain is inevitable. Suffering is optional."),
        quotedata("-J.K. Rowling", "It is our choices that show what we truly are, far more than our abilities."),
        quotedata("-T.S. Eliot", "The greatest proof of the existence of life is the ability to say that one has lived.")
    )

    val randomQuotes = sadList.shuffled().take(5)

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        item {
            Row {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }
        }

        items(randomQuotes.size) { index ->
            val item = randomQuotes[index]
            Card(
                modifier = Modifier
                    .width(500.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(18.dp)
                    .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, color = Color.Red)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.waterco),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .scale(2f)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = item.quote,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraLight
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = item.author,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            }
        }
}








@Composable
fun Anger(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val angerList = listOf(
        quotedata("-Buddha", "Holding on to anger is like grasping a hot coal with the intent of throwing it at someone else; you are the one who gets burned."),
        quotedata("-Cherie Carter-Scott", "Anger makes you smaller, while forgiveness forces you to grow beyond what you were."),
        quotedata("-Confucius", "When anger rises, think of the consequences."),
        quotedata("-Kurup Reddy", "Your mind is like water, my friend. When it is agitated, it becomes difficult to see. But if you allow it to settle, the answer becomes clear"),
        quotedata("-Mark Twain", "Anger is an acid that can do more harm to the vessel in which it is stored than to anything on which it is poured."),
        quotedata("-Seneca", "Anger, if not restrained, is frequently more hurtful to us than the injury that provokes it."),
        quotedata("-Ralph Waldo Emerson", "For every minute you remain angry, you give up sixty seconds of peace of mind."),
        quotedata("-Benjamin Franklin", "Whatever is begun in anger, ends in shame."),
        quotedata("-Horace", "Anger is a short madness."),
        quotedata("-Aristotle", "Anybody can become angry—that is easy. But to be angry with the right person and to the right degree and at the right time and for the right purpose, and in the right way—that is not within everybody’s power and is not easy."),
        quotedata("-Mahatma Gandhi", "The weak can never forgive. Forgiveness is the attribute of the strong."),
        quotedata("-William Arthur Ward", "It is wise to direct your anger towards problems - not people; to focus your energies on answers - not excuses."),
        quotedata("-Thomas Jefferson", "When angry, count to ten before you speak. If very angry, count to one hundred."),
        quotedata("-Publilius Syrus", "How much more grievous are the consequences of anger than the causes of it."),
        quotedata("-Lao Tzu", "Respond intelligently even to unintelligent treatment."),
        quotedata("-Marcus Aurelius", "How much more grievous are the consequences of anger than the causes of it."),
        quotedata("-Elisabeth Kubler-Ross", "We have to heal our wounded world. The chaos, despair, and anger are all indications that we are cut off from our spiritual base, our soul."),
        quotedata("-Ambrose Bierce", "Speak when you are angry and you will make the best speech you will ever regret."),
        quotedata("-Alan Cohen", "You cannot control what happens to you, but you can control your attitude toward what happens to you, and in that, you will be mastering change rather than allowing it to master you."),
        quotedata("-Dalai Lama", "In the practice of tolerance, one's enemy is the best teacher.")
    )

    val randomQuotes = angerList.shuffled().take(5)

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        item {
            Row {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }
        }

        items(randomQuotes.size) { index ->
            val item = randomQuotes[index]
            Card(
                modifier = Modifier
                    .width(500.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(18.dp)
                    .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, color = Color.Red)
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.light),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .scale(7f)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = item.quote,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraLight
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = item.author,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
           }
       }
}







@Composable
fun Love(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val loveList = listOf(
        quotedata("-Angelita Lim", "I saw that you were perfect, and so I loved you. Then I saw that you were not perfect and I loved you even more."),
        quotedata("-Dr. Seuss", "You know you’re in love when you can’t fall asleep because reality is finally better than your dreams."),
        quotedata("-Robert A. Heinlein", "Love is that condition in which the happiness of another person is essential to your own."),
        quotedata("-Audrey Hepburn", "The best thing to hold onto in life is each other."),
        quotedata("-Kurup", "I need you like a heart needs a beat."),
        quotedata("-Albert Einstein", "Gravitation is not responsible for people falling in love."),
        quotedata("-Leo Tolstoy", "All, everything that I understand, I understand only because I love."),
        quotedata("-Lao Tzu", "Being deeply loved by someone gives you strength, while loving someone deeply gives you courage."),
        quotedata("-Mahatma Gandhi", "Where there is love there is life."),
        quotedata("-Aristotle", "Love is composed of a single soul inhabiting two bodies."),
        quotedata("-Helen Keller", "The best and most beautiful things in this world cannot be seen or even heard, but must be felt with the heart."),
        quotedata("-Vincent Van Gogh", "Love is something eternal; the aspect may change, but not the essence."),
        quotedata("-Blaise Pascal", "The heart has its reasons which reason knows not."),
        quotedata("-Jane Austen", "There is no charm equal to tenderness of heart."),
        quotedata("-Fyodor Dostoevsky", "What is hell? I maintain that it is the suffering of being unable to love."),
        quotedata("-Pablo Neruda", "I love you without knowing how, or when, or from where. I love you simply, without problems or pride."),
        quotedata("-Oscar Wilde", "Keep love in your heart. A life without it is like a sunless garden when the flowers are dead."),
        quotedata("-William Shakespeare", "Love looks not with the eyes, but with the mind, And therefore is winged Cupid painted blind."),
        quotedata("-Victor Hugo", "Life is the flower for which love is the honey."),
        quotedata("-Charles Dickens", "Have a heart that never hardens, and a temper that never tires, and a touch that never hurts.")
    )

    val randomQuotes = loveList.shuffled().take(5)

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        item {
            Row {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }
        }

        items(randomQuotes.size) { index ->
            val item = randomQuotes[index]
            Card(
                modifier = Modifier
                    .width(500.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(18.dp)
                    .shadow(elevation = 14.dp, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, color = Color.Red)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.waterco),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .scale(2f)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = item.quote,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraLight
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = item.author,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            }
       }
}
