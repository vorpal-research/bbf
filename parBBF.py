# import time
# import random
#
# from multiprocessing import Process, Manager
# import subprocess
#
# from os import listdir
#
# from os.path import isfile, join
#
#
# def lol():
#     print("LOL")
#
#
# def bbf(filename):
#     res = subprocess.run(['java', '-jar', 'target/BackendBugFinder-1.0-SNAPSHOT-jar-with-dependencies.jar', filename], stdout=subprocess.PIPE)
#     print("RES = ")
#     print(res.stdout)
#     return res.stdout
#
#
# if __name__ == '__main__':
#     NUMOFPROCESSES = 2
#     MINUTE = 60
#     HOUR = 60 * 60
#     timeout = 2 * HOUR
#     step =  2
#     myPath = "tmp/arrays/"
#     files = [myPath + f for f in listdir(myPath) if isfile(join(myPath, f)) and f.endswith(".kt")]
#     processes = []
#     for i in range(NUMOFPROCESSES):
#         randomFile = random.choice(files)
#         p = Process(target=bbf, args=(randomFile,))
#         p.start()
#         processes.append(tuple((p, time.time())))
#     while True:
#         for i in range(processes.__len__()):
#             (p, t) = processes[i]
#             print("process = ", p.pid, "is alive = ", p.is_alive(), "time elapsed = ", time.time() - t)
#             if (not p.is_alive()) or time.time() - t > timeout:
#                 p.terminate()
#                 p = Process(target=bbf, args=(random.choice(files), ))
#                 p.start()
#                 processes[i] = tuple((p, time.time()))
#         print("\n\n")
#         time.sleep(step)


def mnkGP(x,y): # функция которую можно использзовать в програме
              n=len(x) # количество элементов в списках
              s=sum(y) # сумма значений y
              s1=sum([1/x[i] for i in  range(0,n)]) #  сумма 1/x
              s2=sum([(1/x[i])**2 for i in  range(0,n)]) #  сумма (1/x)**2
              s3=sum([y[i]/x[i]  for i in range(0,n)])  # сумма y/x
              a= round((s*s2-s1*s3)/(n*s2-s1**2),3) # коэфициент а с тремя дробными цифрами
              b=round((n*s3-s1*s)/(n*s2-s1**2),3)# коэфициент b с тремя дробными цифрами
              s4=[a+b/x[i] for i in range(0,n)] # список значений гиперболической функции
              so=round(sum([abs(y[i] -s4[i]) for i in range(0,n)])/(n*sum(y))*100,3)   # средняя ошибка аппроксимации
              print(a, b, so)


x=[200, 199, 198, 197, 49, 8, 9]
y=[5, 5, 5, 5, 20, 30, 29] # данные для проверки по функции y=1/x
mnkGP(x,y)