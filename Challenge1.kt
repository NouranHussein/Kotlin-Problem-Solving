package com.example.evapharma

fun regex(s:String,  p:String):Boolean
{

    var item:Int=0
    while ( item <p.length)
    {
        if (s==p) return true
        if(p[item]=='*')
        {
            if(p.length==1) return true
            else
            {
                var wrng:Boolean=false
                for (item2 in item+1..p.length)
                {
                    if(p[item2]=='?'){wrng=true; item=item2-1;break;}
                    if(p[item2]!='*')
                    {
                        if(s.indexOf(p[item2],item)==-1)
                            return false;

                    }

                }
                if(!wrng)
                    return true;




            }
        }

        if(p[item]!='?' && p[item]!=s[item] )
        {
            return false;
        }
    item++
    }
    if(p.length!=s.length)return false;
    return true;

}
fun main(args:Array<String>)
{

     val s = readLine()
    val p = readLine()

    val ans=regex(s.toString(),p.toString());
    if(ans)
        println("true")
    else
        println("false")
}