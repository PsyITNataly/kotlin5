import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(0, Likes(0))

        val result = WallService.add(post)

        assertEquals(1,result.id)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateTestFalse() {
        val newPost = Post(0, Likes(0))

        val result = WallService.update(newPost)

        assertFalse(result)
    }
    //assertEquals(false,result)

    @Test
    fun updateTestTrue() {
        val service = WallService
        service.add(Post(1,Likes(0)))
        service.add(Post(2,Likes(0)))
        service.add(Post(3,Likes(0)))

        val update = Post(1,Likes(0))


        val result = service.update(update)

        assertTrue(result)
    }

}